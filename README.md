# fizzbuzz
Implements the rules of Fizz Buzz game: a user gives a number (or many) and expects a reply with numbers divisible by three replaced with the word "fizz" and numbers divisible by five with the word "buzz".
The game is playable through an HTTP API.
/fizzbuzz API request:
```json
{
  "numbers": [
    1,
    2,
    3,
    15,
    45
  ]
}
```
Response:
```json
{
  "results": [
    "1",
    "2",
    "fizz",
    "fizzbuzz",
    "fizzbuzz"
  ]
}
```
