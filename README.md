
# EVEREST

### Programming Test

## Dating App

Author: Diego Octavio Labastida Tolalpa

## Requested Points

1. Endpoint to register users.
2. Update User's model hobbies property to be an array enum.
3. Validate the body data when registering a user.
4. Validate that the user is not registered.
5. Add error handling.
6. Review and fix the error when making a request to sqlite.
7. Validate match model so that it allows saving the match between two users.
8. Endpoint per user and be able to consult the POSSIBLE matches that they have from hobbies and their sexual Orientation.
9.  Make a match between two users.
10. Make an endpoint of the matches that a user has made.
11. Perform service to check the match percentage between two users.
12. Add relationships between Match and Users.

## API

### MatchController

#### 1. Match Possibilities

    POST /match/possibilities/{id}

#### 2. Make match with two Ids

    POST /match/make/{id}/{matchId}

#### 3. Get all matches

    GET /match/{id}

#### 4. Match Percentage

    POST /match/percentage/{id}/{matchId}

### GeneralController
### User Model

#### 1. Get Users

    GET /basic/users

#### 2. Get User

    GET /basic/user/{id}

#### 3. Save User
    
    POST /basic/user

#### 4. Save Users

    POST /basic/users

### User Model

#### 1. Get Profiles

    GET /basic/profiles

#### 2. Get Profile

    GET /basic/profile/{id}

#### 3. Save User

    POST /basic/profile

### Profile Model

#### 1. Get Profiles

    GET /basic/profiles

#### 2. Get Profile

    GET /basic/profile/{id}

#### 3. Save User

    POST /basic/profile

### Job Model

#### 1. Get Jobs

    GET /basic/jobs

#### 2. Get Job

    GET /basic/job/{id}

#### 3. Save Job

    POST /basic/job

### Contract Model

#### 1. Get Contracts

    GET /basic/contracts

#### 2. Get Contract

    GET /basic/contract/{id}

#### 3. Save Contract

    POST /basic/contract
