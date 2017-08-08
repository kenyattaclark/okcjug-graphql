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
+++
Assumming that we know the characters ID we might ask:
```
GET - /people/{id}
```
+++
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
+++
Retrieve planet information
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
+++
Finally, let's retrieve film information
```
GET - /films/1
GET - /films/2
GET - /films/3
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
