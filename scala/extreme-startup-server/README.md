# Extreme Startup Server #

## Build & Run ##

```sh
$ cd Extreme_Startup_Server
$ ./sbt
> jetty:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.

## Debugging ##

Scalatra can be [debugged in your IDE](http://www.scalatra.org/2.2/getting-started/ide-support.html).

## TODO ##

* appropriate response codes
* sort out the (rather bloated?) sbt