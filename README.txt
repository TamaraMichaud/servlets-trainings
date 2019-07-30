// Keystore password:: s3Cur1T_e // CN=TMich, OU=Personal, O=Personal, L=Personal, ST=Personal, C=UK
^^ pointless if we're moving this project around... the cert would need to be with me :/


Servlet calls:

List users: GET /users
 - returns a HTML page containing users

Show new user page: GET /newuser
	- returns a HTML page with a form to add a new user
	
Add user: POST /users
	- Adds a user using the data in the request body.
	- Returns the /users HTML page
	- The URI of the created user resource is automatically assigned and returned in the response Location header field.

Show update user page: GET /updateuser/<user-id>
	- returns a HTML page with a form to update a user
	
Update user: PUT /users/<user-id>
	- Updates a user using the data in the request body.
	- Returns the /users HTML page
 
Delete user: DELETE /users/<user-id>
	- Deletes a user using the data in the request query string.
	- Returns the /users HTML page

