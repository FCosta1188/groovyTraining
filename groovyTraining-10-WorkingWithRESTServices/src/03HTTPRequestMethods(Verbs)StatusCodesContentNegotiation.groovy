// HTTP Request Methods (Verbs)
/*
- GET: read/select
- POST: create/insert
- PUT: update
- DELETE: delete
*/

// HTTP Status Codes
/*
1xx: informational
2xx: success
    201: OK
    201: Created
    204: No Content
3xx: redirection (resource has been moved)
    301: Moved Permanently
    304: Not Modified
    307: Temporary Redirect
4xx: client error (eg: 404 page not found)
    400: Bad Request
    401: Unauthorized
    403: Forbidden
    404: Not Found
5xx: server error
    500: Internal Server Error
    502: Bad Gateway
*/

// Content Negotiation
/*
Content negotiation refers to mechanisms defined as a part of HTTP that make it possible to serve different
versions of a document (or more generally, representations of a resource) at the same URI, so that user agents
can specify which version fits their capabilities the best. One classical use of this mechanism is to serve
an image in GIF or PNG format, so that a browser that cannot display PNG images (e.g. MS Internet Explorer 4)
will be served the GIF version.

A resource may be available in several different representations;
for example, it might be available in different languages or different media types.
One way of selecting the most appropriate choice is to give the user an index page
and let them select the most appropriate choice; however it is often possible to automate
the choice based on some selection criteria.
*/
