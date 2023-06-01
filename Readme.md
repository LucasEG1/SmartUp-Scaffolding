# API-REST Kata Basics

### Endpoints:
#### GET
    [GET] /user/{id}
- Returns HTTP 200 "OK"

#### POST
    [POST] /user
- Body must include the user object without its ID attribute
- Returns HTTP 201 "Created"

#### PUT
    [PUT] /user
- Body must include the user object with its ID attribute
- Returns HTTP 200 "OK"

#### PATCH
    [PATCH] /user
- Modifies the specified part of a resource
- Must follow JSON Patch
- Returns HTTP 200 "OK"

#### DELETE
    [DELETE] /user/{id}
- Deletes user by its ID
- Returns HTTP 200 "OK"
