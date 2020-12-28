# Instructions
The instructions below are the explicit way of creating and pushing a production or development build.  Have a look at the npm scripts I've provided to make this process simpler.

## Prerequistes
You should know and understand how to create and run a Google Apps Script. If you haven't built a Google Apps Script before, then stop here and go through Google's official [tutorials](https://developers.google.com/apps-script/articles/tutorials).  Then, I also highly recommend you work through the video tutorial [series](https://www.youtube.com/watch?v=aPJ-2U45BpA&list=PLv9Pf9aNgemv62NNC5bXLR0CzeaIj5bcw) from 'Learn Google Spreadsheets'.

## Getting Started
As a first step, I suggest you try building your first script using the default source file, and the npm script `prod`. This way, you can be confident that you understand the steps necessary to develop and run a script using Google's command-line interface [clasp](https://developers.google.com/apps-script/guides/clasp). The npm scripts `create`, followed by `prod` will create a spreadsheet and a script `cljs-gas-app-example`. The source file for this script, `core.cljs` will log "Hello cljs from GAS with clasp" to the script console and write "I don't do anything yet! to cell A1". To run this script, find the `cljs-gas-example` spreadsheet in your Google Drive folder, select `Tools->Script Editor` and, from the script editor, select `Run`.

## Setup
1. `npm install` to install the clasp cli tools
2. `npx clasp login` to login to and authorize the Clasp Api
3. `npx clasp create --title <title> --type <type> --rootDir ./export` to create the spreadsheet and script.

## Development Environment
Any code that you write for Google's Workspace API must be uploaded and executed on Google Servers. Therefore, developing and testing locally is limited. Forget about a REPL, your feedback cycle is now: compile, upload (using the `clasp push` command) and debug using console.log debugging. You could mock out the parts of Google's API (see Laurent Charignon's [blog post](https://blog.laurentcharignon.com/post/mail-merge-in-100-lines-of-clojure/) for an example approach. But that's a lot of work for a questionable return.

## Development Build
The following will compile the source files using the map from `dev.edn`the map from `dev.edn`. The differences from `build.edn` are `{:pseudo-names :true}` with `{:pretty-print true}`.  With this configuration, your apps script function names and lines are preserved, in case there is a function missing from `resources/gas.ext.js` externs file. Then, add an externs entry for this missed case.
```
$ npm run dev
...
# After successful compiliation
# push your dev build (i.e., Apps Script) to your Google Drive folder
$ npm run push
```
## Production Build
The following will compile the src directory files once, using `{:mode :advanced}`, `{:pseudo-names false}`, and `{:pretty-print false}`. Then, push your Apps Script `export/Code.gs` to your Google Drive folder.
```
$ npm run build
...
# After successful compiliation
# push your dev build (i.e., Apps Script) to your Google Drive folder
$ npm run push
```

## Contributing
Pull requests are welcome.
