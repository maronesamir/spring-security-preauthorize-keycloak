This [article](https://www.wstutorial.com/am/keycloak-custom-user-attributes-preauthorize.html) is about  how to use keycloak custom user attributes with spring security method **preauthorize**.

Curl commands:
```
ATOKEN=$(curl --data "grant_type=password&client_id=demo-app&username=johndoe&password=johndoe" http://localhost:8090/auth/realms/wstutorial/protocol/openid-connect/token | jq -r '.access_token')
curl http://localhost:8080/custom -H "Authorization: bearer $ATOKEN" --insecure
```

More articles can be found here: https://wstutorial.com