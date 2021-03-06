# Support Transport Layer Security (TLS)

Transport Layer Security (TLS) is a very common security way when transport data through Internet. In some use cases,
end users report the background:

> Target(under monitoring) applications are in a region, which also named VPC, at the same time, the SkyWalking backend is in another region (VPC).
>
> Because of that, security requirement is very obvious.

## Authentication Mode

Only support **no mutual auth**.

- Use this [script](../../../../../tools/TLS/tls_key_generate.sh) if you are not familiar with how to generate key
  files.
- Find `ca.crt`, and use it at client side
- Find `server.crt` and `server.pem`. Use them at server side.

## Open and config TLS

### Agent config

- Place `ca.crt` into `/ca` folder in agent package. Notice, `/ca` is not created in distribution, please create it by
  yourself.

Agent open TLS automatically after the `/ca/ca.crt` file detected.

o make sure can't access other ports out of region (VPC), such as firewall, proxy.