{
  "SecurityAndAuthenticationService": {
    "Methods": {
      "createAccessControl": {
        "args": {
          "targetType": "String",
          "targetId": "String",
          "permissions": "Set<Permissions>"
        },
        "returnType": "AccessControl"
      },
      "updateAccessControl": {
        "args": {
          "accessControlId": "Long",
          "permissions": "Set<Permissions>"
        },
        "returnType": "AccessControl"
      },
      "deleteAccessControl": {
        "args": {
          "accessControlId": "Long"
        },
        "returnType": "void"
      },
      "createStaffAccount": {
        "args": {
          "name": "String",
          "email": "String",
          "password": "String",
          "role": "String"
        },
        "returnType": "StaffAccount"
      },
      "updateStaffAccount": {
        "args": {
          "staffAccountId": "Long",
          "name": "String",
          "email": "String",
          "password": "String",
          "role": "String"
        },
        "returnType": "StaffAccount"
      },
      "deleteStaffAccount": {
        "args": {
          "staffAccountId": "Long"
        },
        "returnType": "void"
      },
      "createAgencyAccount": {
        "args": {
          "name": "String",
          "email": "String",
          "password": "String",
          "role": "String"
        },
        "returnType": "AgencyAccount"
      },
      "updateAgencyAccount": {
        "args": {
          "agencyAccountId": "Long",
          "name": "String",
          "email": "String",
          "password": "String",
          "role": "String"
        },
        "returnType": "AgencyAccount"
      },
      "deleteAgencyAccount": {
        "args": {
          "agencyAccountId": "Long"
        },
        "returnType": "void"
      },
      "authenticateUser": {
        "args": {
          "credentials": "Credentials"
        },
        "returnType": "boolean"
      }
    }
  }
}