# ExpS GitHub action Demo / Prototype

- GitHub action [file](.github/workflows/main.yml) defines the
  job by specifying a query and the number of expressions to extract
- GitHub action [implementation](docker)
- In this configuration the [source code](src/main/java) of this project
  is analyzed and `2` expressions matching the query `(() "?" () ":" ())`
  (Java ternary operator) are extracted, printed on the action log and
  the activities ndjson file is provided as a build artifact

TODO:
- Upload on ExpressionTutor
- Issue generation
- Publish the action for easy consumption