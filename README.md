# JWT-Token-Based-Login-System-Using-Spring-Boot

## Features
- "http://localhost:8080" will take you to the dashboard page. But before accesing the dashboard page, you need to authenticate yourself.
- For the very first time, you will be redirected to authentiicate through the "http://localhost:8080/login" (which is going to show you a login page).
- After successfully login for the first time, you will get a JWT token and the token is going to get stored in the localStorage (This part is done through frontend because backend can't access the localStorage).
- Now everytime when you try to visit the dashboard page through "http://localhost:8080", you will be automatically authenticate with the help of JWT token (until the token get expired or you press the logout button and remove the JWT token from the local storage).
- The validation time for the token here is 5 minute (Countdown starts from the first successful login. You can increase or decrease the validation time of the token from JWTService.java)
- Instead of all these features, a new person can register and login using his registered credentials. (The registration page is linked at the login page, so you can register whenever you are trying to login for the first time).

## Pre-requisite:
- You sould have knowledge of spring boot.
- You should have knowledge of how spring security works.
- You should have knowledge of how role based authentication works with database.
- You should have knowledge of JWT token and JWT token based authentication.

## Reference of the idea used behind the JWT token authentication
- What is JWT and Why (https://www.youtube.com/watch?v=CELcrLHQmZs)
- Spring Security Project Setup for JWT (https://www.youtube.com/watch?v=dFzvVoS-sRE)
- Spring Security | Generating JWT Token (https://www.youtube.com/watch?v=e2xut5xpmmk)
- Spring Security | Validating JWT Token (https://www.youtube.com/watch?v=ZhtF4i-iB1A)
