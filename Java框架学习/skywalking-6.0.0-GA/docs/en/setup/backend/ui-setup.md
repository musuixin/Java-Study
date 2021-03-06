# UI

SkyWalking UI distribution is already included in our Apache official release.

## Startup

Startup script is also in `/bin/webappService.sh`(.bat). UI runs as an OS Java process, powered-by Zuul.

## Settings

Setting file of UI is  `webapp/webapp.yml` in distribution package. It is constituted by three parts.

1. Listening port.
1. Backend connect info.
1. Auth setting.

```yaml
server:
  port: 8080

collector:
  path: /graphql
  ribbon:
    ReadTimeout: 10000
    # Point to all backend's restHost:restPort, split by , 
    listOfServers: 10.2.34.1:12800,10.2.34.2:12800

security:
  user:
    # username
    admin:
      # password
      password: admin

```

## Another Open Source UI RocketBot

A modern and awesome UI for Apache SkyWalking.

Github: [https://github.com/TinyAllen/rocketbot](https://github.com/TinyAllen/rocketbot)
