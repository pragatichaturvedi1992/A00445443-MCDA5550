# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

> Don't forget to run `npm install` first to install the Node packages

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.\
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

## About the app

The app has an `App` component and four components in `components/`:
- `<Covid19 />`
- `<Provinces />`
- `<Territories />`
- `<Province />`

`api.js` acts like the "3rd Party" api of the app

## Hints 💡

 * You can test `getTerritories` in `api.js` and makes sure it returns an **array** of 3 
 * You can mock the `covid19tracker` api 
 * You can test if `<Provinces />` returns 10 `<Province />` components

