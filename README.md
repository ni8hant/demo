● Architecture​:MicroserviceArchitecture
● Language:​ Java with SpringBoot Framework
● Caching​(ifrequired)
● Database​: MySQL(any)
Design Microservices as given below:
1. Account Service:​ This service will perform SignUp/SignIn operation.
User Will directly Interact with the Service.
Detailed Description of the services:
1. Account Service:​ Use caching to increase performance whenever possible.
User Table
username (Text) password (Text) token

(Text, Default: null)
user123 pass123 token123
● Sign Up:​ Add unique username to user table, use caching to increase performance whenever possible​.
Type​ POST
http://localhost:8080/account/sign-up
Request Params
username user123
Username for the account
password SomePassword
Password for the account. Validation is not Required.
Response Type
application/json
Example Response
{
​&quot;status&quot;​: ​&quot;ok&quot;,​
​&quot;message&quot;​: ​&quot;Account Created&quot;}

Response Params

status ok | error
Tells if the network call was successful or not
message Account Create | Account Already Exist
Notifies if able to create the account successfully or not
● Sign In:​ Sign in with the username and password and a token
Type​ POST
http://localhost:8080/account/sign-in
Request Params
username user123
Username for the account
password SomePassword
Password for the account.

