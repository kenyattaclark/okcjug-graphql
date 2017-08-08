---

### Lions and Tigers and GraphQL (Oh My!)

<span style="color:gray">An introduction to GraphQL. A query language for your API</span>

---
### Why GraphQL?
---
### Requirements

Build a UI to show information about a Star Wars character.  For example, Darth Vader, and all the films this character appeared in. This view should display the characters’s name, birth year, planet name, and the titles of all the films in which they appeared.
---
### Sample Response
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
---
Assumming that we know the characters ID we might ask:
```
GET - /people/{id}
```
---
The response may look like:
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
---
