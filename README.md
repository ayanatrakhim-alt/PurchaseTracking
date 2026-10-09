# PurchaseTracking — Lab 2 (Spring Boot Integration)

## Package Architecture

```text
  dto          client        handler         config
  (JSON)       (HTTP)        (HTTP)          Application
                                             RequestService
       \            \            /                |
        \            \          /           injects Rule
         \            \        /
                     domain
              RequestId  RequestStatus  RequestPolicy
              Rule + TransitionRule + UnapprovedCannotOrder