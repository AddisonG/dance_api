# Installing

## Fuck Snap

A necessary evil:

```
sudo snap install kotlin --classic
sudo snap install gradle --classic
```

Apparently there's a thing called `sdk`, but hell, Java is a messed up language.
It's just barely compatible with Linux, and that's saying something.

## DB

```
sudo apt install postgresql
sudo service postgresql status
```

Then:

```
sudo -u postgres psql
CREATE USER username WITH PASSWORD 'password';
CREATE DATABASE dance;
```


## Running

Then:

```
./gradlew bootRun
```


## Testing

Create:

```
curl -H "Content-Type: application/json" -X POST -d '{"username":"example","email":"example@example.com","password":"password"}' http://localhost:8080/user
```

Get:

```
curl http://localhost:8080/users
```

Delete:

```
curl http://localhost:8080/user/1 -X DELETE
```
