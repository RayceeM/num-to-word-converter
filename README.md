# num-to-word-converter

An application that converts a number into words

## Development mode
To quickly get started run:
`lein run`

Alternatively, bundle up your project and all its dependencies in a single executable jar  with the following command:

`lein uberjar`

then run the `java -jar` command:
```
 java -jar num-to-word-converter-0.1.0-standalone.jar [args]
```

### Testing 
Run tests with the following command:
`lein test`

## Bugs
- Any number above four digits doesn't get converted correctly.

## To-do
- [ ] Change to use a loop instead.
- [x] Convert numStrings to numbers.
- [ ] Test cases

## License
Copyright © 2021

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
