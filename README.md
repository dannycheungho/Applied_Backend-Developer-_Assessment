## API Endpoints
#### Get All To-Do Items

    GET /api/todo

#### Get To-Do Items by User ID
    GET /api/todo/{userId}

#### Create To-Do Item
    POST /api/todo/
    
###### Example Request Body:

    {
    "userId": "danny",
    "description": "remind me having a dinner on 7pm.",
    "completed": false
    }

#### Update To-Do Item

    PUT /api/todo/{toDoItemId}?isCompleted={isCompleted}

###### Request Parameters
    Parameter	Type	Description

    toDoItemId	Long	Required. ID of the to-do item to be updated.
    isCompleted	Boolean	Required. New completion status of the to-do item.
