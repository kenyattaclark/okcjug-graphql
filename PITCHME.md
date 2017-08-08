---

#### Lions and Tigers and GraphQL (Oh My!)

![GraphQL Logo](assets/graphql.png)

<span style="color:gray"><h4>An introduction to GraphQL. A query language for your API</h4></span>

---
About Me
* Developer @ MBO Partners for 7 years
* Work on the back end API team serving multiple clients
	* Mobile
	* Web
	* Integration
---
### Why GraphQL?
+++
![Corn Flower](assets/cornflower.jpg)
+++
### Requirements

Build a UI to show information about a Star Wars character.  For example, Darth Vader, and all the films this character appeared in. This view should display the characters’s name, birth year, planet name, and the titles of all the films in which they appeared.
+++
Data wanted
```
{
	"person": {
	"name": "Darth Vader",
	"birthYear": "41.9BBY",
	"planet": {
		"name": "Tatooine"
	},
	"films": [
		{ "title": "A New Hope" },
		{ "title": "The Empire Strikes Back" },
		{ "title": "Return of the Jedi" },
		{ "title": "Revenge of the Sith" }
	]
  }
}

```
@[2-4](Person resource)
@[5-7](Planet resource)
@[8-13](Film resource)
+++
### A RESTful Approach
+++
Retrieving character
```
GET - /people/{id}
```
+++
Response
```
{
  "name": "Darth Vader",
  "height": "202",
  "mass": "136",
  "hair_color": "none",
  "skin_color": "white",
  "eye_color": "yellow",
  "birth_year": "41.9BBY",
  "gender": "male",
  "homeworld": "https://swapi.co/api/planets/1/",
  "films": [
    "https://swapi.co/api/films/2/",
    "https://swapi.co/api/films/6/",
    "https://swapi.co/api/films/3/",
    "https://swapi.co/api/films/1/"
  ],
  "species": [
    "https://swapi.co/api/species/1/"
  ],
  "vehicles": [],
  "starships": [
    "https://swapi.co/api/starships/13/"
  ],
  "created": "2014-12-10T15:18:20.704000Z",
  "edited": "2014-12-20T21:17:50.313000Z",
  "url": "https://swapi.co/api/people/4/"
}
```
@[2,8](Person information wanted)
+++
Retrieving planet information
```
GET - /planets/1
```
+++
```
{
    "name": "Tatooine", 
    "rotation_period": "23", 
    "orbital_period": "304", 
    "diameter": "10465", 
    "climate": "arid", 
    "gravity": "1 standard", 
    "terrain": "desert", 
    "surface_water": "1", 
    "population": "200000", 
    "residents": [
        "https://swapi.co/api/people/1/", 
        "https://swapi.co/api/people/2/", 
        "https://swapi.co/api/people/4/", 
        "https://swapi.co/api/people/6/", 
        "https://swapi.co/api/people/7/", 
        "https://swapi.co/api/people/8/", 
        "https://swapi.co/api/people/9/", 
        "https://swapi.co/api/people/11/", 
        "https://swapi.co/api/people/43/", 
        "https://swapi.co/api/people/62/"
    ], 
    "films": [
        "https://swapi.co/api/films/5/", 
        "https://swapi.co/api/films/4/", 
        "https://swapi.co/api/films/6/", 
        "https://swapi.co/api/films/3/", 
        "https://swapi.co/api/films/1/"
    ], 
    "created": "2014-12-09T13:50:49.641000Z", 
    "edited": "2014-12-21T20:48:04.175778Z", 
    "url": "https://swapi.co/api/planets/1/"
}
```
@[2](Planet information wanted)
+++
Retrieving film information
```
GET - /films/1
```
```
GET - /films/2
```
```
GET - /films/3
```
```
GET - /films/6
```
+++
```
{
    "title": "A New Hope", 
    "episode_id": 4, 
    "opening_crawl": "It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy....", 
    "director": "George Lucas", 
    "producer": "Gary Kurtz, Rick McCallum", 
    "release_date": "1977-05-25", 
    "characters": [
        "https://swapi.co/api/people/1/", 
        "https://swapi.co/api/people/2/", 
        "https://swapi.co/api/people/3/", 
        "https://swapi.co/api/people/4/", 
        "https://swapi.co/api/people/5/", 
        "https://swapi.co/api/people/6/", 
        "https://swapi.co/api/people/7/", 
        "https://swapi.co/api/people/8/", 
        "https://swapi.co/api/people/9/", 
        "https://swapi.co/api/people/10/", 
        "https://swapi.co/api/people/12/", 
        "https://swapi.co/api/people/13/", 
        "https://swapi.co/api/people/14/", 
        "https://swapi.co/api/people/15/", 
        "https://swapi.co/api/people/16/", 
        "https://swapi.co/api/people/18/", 
        "https://swapi.co/api/people/19/", 
        "https://swapi.co/api/people/81/"
    ], 
    "planets": [
        "https://swapi.co/api/planets/2/", 
        "https://swapi.co/api/planets/3/", 
        "https://swapi.co/api/planets/1/"
    ], 
    "starships": [
        "https://swapi.co/api/starships/2/", 
        "https://swapi.co/api/starships/3/", 
        "https://swapi.co/api/starships/5/", 
        "https://swapi.co/api/starships/9/", 
        "https://swapi.co/api/starships/10/", 
        "https://swapi.co/api/starships/11/", 
        "https://swapi.co/api/starships/12/", 
        "https://swapi.co/api/starships/13/"
    ], 
    "vehicles": [
        "https://swapi.co/api/vehicles/4/", 
        "https://swapi.co/api/vehicles/6/", 
        "https://swapi.co/api/vehicles/7/", 
        "https://swapi.co/api/vehicles/8/"
    ], 
    "species": [
        "https://swapi.co/api/species/5/", 
        "https://swapi.co/api/species/3/", 
        "https://swapi.co/api/species/2/", 
        "https://swapi.co/api/species/1/", 
        "https://swapi.co/api/species/4/"
    ], 
    "created": "2014-12-10T14:23:31.880000Z", 
    "edited": "2015-04-11T09:46:52.774897Z", 
    "url": "https://swapi.co/api/films/1/"
}
```
@[2](Film information wanted)
+++
Recap
- Retrieved character by id |
- Retrieved planet by id |
- Retrieved film by id |
- Retrieved film by id |
- Retrieved film by id |
- Retrieved film by id |
+++
### Oh My!
![Wizard Of Oz](assets/lions-tigers-bears.jpg)
+++
#### The Problem With RESTful APIs
- Multiple endpoints often require multiple round trips to get data |
- There is no client request language to control the amount of data returned in responses |
- Versioning can introduce more endpoints |
+++
Can we reduce the number of calls?
+++
### GraphQL Approach
+++
```
GET or POST - /graphql?query={...}
```
+++
GraphQL Query
```
{
  person(id: "4") {
    name,
    birthYear,
    homeWorld {
      name
    },
    films {
      title
    }
  }
}
```
+++
Response
```
{
  "data": {
    "person": {
      "name": "Darth Vader",
      "birthYear": "41.9BBY",
      "homeWorld": {
        "name": "Tatooine"
      },
      "films": [
        {
          "title": "The Empire Strikes Back"
        },
        {
          "title": "Revenge of the Sith"
        },
        {
          "title": "Return of the Jedi"
        },
        {
          "title": "A New Hope"
        }
      ]
    }
  }
}
```
+++
This response looks like what we wanted right?
```
{
  "data": {
    "person": {
      "name": "Darth Vader",
      "birthYear": "41.9BBY",
      "homeWorld": {
        "name": "Tatooine"
      },
      "films": [
        {
          "title": "The Empire Strikes Back"
        },
        {
          "title": "Revenge of the Sith"
        },
        {
          "title": "Return of the Jedi"
        },
        {
          "title": "A New Hope"
        }
      ]
    }
  }
}
```
+++
### Why GraphQL?
- Multiple round trips required to fetch data
- Decouples clients from server
- Ask for what they need
---
### What is GraphQL?
- A query language for your API |
- A server-side runtime for executing queries by using a type system you define for your data |
- Request are either: |
	- Queries |
	- Mutations |
- Not tied to a specific database or storage engine |
- Backed by existing services / data |
+++
## Queries and Mutations
+++
### Queries
+++
Simple Query
```
query {
	person {
    name
  }
}
```
+++
Traversal Query
```
query {
	person {
    name
    films {
      title
    }
  }
}
```
+++
### Arguments
+++
Single argument
```
query {
	person(id: "20") {
    name
    height
  }
}
```
+++
Multiple arguments
```
query {
	person(id: "20") {
    name
    height(unit: "FEET")
  }
}
```
+++
### Aliases
+++
```
query {
	person(id: "1") {
		name
		height
	}
	person(id: "2") {
		name
		height
	}
}
```
+++
Query with alias
```
query {
	luke: person(id: "1") {
		name
		height
	}
	c3p0: person(id: "2") {
		name
		height
	}
}
```
+++
### Fragments
+++
Verbose query
```
query {
	leftComparison: person(id: "1") {
		name
		height
		films {
			title
			episodeId
		}
	}
	rightComparison: person(id: "2") {
		name
		height
		films {
			title
			episodeId
		}	
	}
}
```
+++
Using fragments
```
query {
	leftComparison: person(id: "1") {
		...comparisonFields
	}
	rightComparison: person(id: "2") {
		...comparisonFields
	}
}

fragment comparisonFields on Person {
	name
	height
	films {
		title
		episodeId
	}	
}
```
+++
### Variables
+++
Dynamic query
```
query CharacterAndMovies($personId: String) {
	person(id: $personId) {
		name
		height
		films {
			title
			episodeId
		}
	}
}

{
	# Variables block
	"personId": "1"
}
```
+++
Dynamic query with default
```
query CharacterAndMovies($personId: String = "2") {
	person(id: $personId) {
		name
		height
		films {
			title
			episodeId
		}
	}
}

{
	# Empty variables block

}
```
+++
Directives
```
query Character($personId: String, $withFilms: Boolean!) {
	person(id: $personId) {
		name
		height
		films @include(if: $withFilms) {
			title
			episodeId
		}
	}
}

{
	# Variables block
	"personId": "1"
	"withFilms": false
}
```
+++
### Schemas and Types
- Root Object
	- The jumping off point to get at data
- Object Types and Fields
	- think Java object
	- think Java field / property
+++
### Schemas and Types
- Scalar Types
	- Int - signed 32 bit integer
	- Float
	- String
	- Boolean
	- ID
		The ID scalar type represents a unique identifier, often used to refetch an object or as the key for a cache. 
	- Date - implementation specific
+++
### Schemas and Types
- Other Types
	- Lists
	- Interfaces
		- think Java interfaces
	- Input Types
		Complex types that can be passed as arguments
---
## GraphQL And Java
+++
### Tools
* GraphQL Java
* GraphQL Spring Boot
	* Forked from oembedler 
* GraphQL Common
	* Not being maintained
	* GraphQL Spring Boot dropped support - Supported version 3.1.1
* Graph*i*QL
---
### With Great Power...
![Uncle Ben](assets/uncleben.jpg)
+++
### GraphQL Concerns
- Resource exhaustion |
- Authentication and authorization |
- Caching data |
- Paging |
---
Who's Using GraphQL?
![Facebook](assets/facebook.png =150x150)
![Github](assets/github.png =150x150)
![Pintrest](assets/pintrest.png =150x150)
![Coursera](assets/coursera.png =150x150)
![Shopify](assets/shopify.png =150x150)
---
Resources
- http://graphql.org
- https://github.com/graphql-java/graphql-java
- https://github.com/graphql-java/graphql-spring-boot
- https://github.com/oembedler/spring-graphql-common
- https://github.com/kenyattaclark/okcjug-graphql
- Star Wars API
	- https://swapi.co/
	- http://graphql.org/swapi-graphql/
+++
### Questions?
+++
### Contact Me
- kenyatta.clark@gmail.com
- @kenyattaclark
+++
### Thanks!
