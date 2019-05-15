docker run -d --name test-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=test-mysql mysql:5

docker exec -it test-mysql mysql -u root --password=pass
