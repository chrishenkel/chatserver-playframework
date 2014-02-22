#Restful Chat Server written in Play Framework utilizing GCM 

## Description
A chat server designed as a restful endpoint. Uses GCM (Google Cloud Messenging) for push based messenging.

##To setup for heroku deployment

1. clone git repository
2. type "heroku create" to create remote branch
3. type "git push heroku master"
4. lookup database credentials on https://postgres.heroku.com/databases for the database that play just created and follow the instructions in conf/prod.conf for setting up database credentials
5. commit all changed files 
6. push to heroku with "git push heroku master"
7. once all files are commited successfully, type "heroku restart"
8. check everything is working by making a new account with curl executing this command
"curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"username":"username","password":"password"}' http://{your_endpoint}/register"