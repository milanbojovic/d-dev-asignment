#!/bin/bash

#Remove old polls file
rm ./polls
#Download polls file from WEB
wget https://boiling-tor-31289.herokuapp.com/users/me/polls

#Build the Mongo image
sudo docker build -t mymongo .

#Run mongo container
docker run -d -p 27017:27017 mymongo

#Import polls to running mongo database
mongoimport --db "doodle" --collection "polls" --type json --file "polls" --jsonArray

#Downside of this approach is that user has to have installed mongo and mongoimport on target machine !!!
