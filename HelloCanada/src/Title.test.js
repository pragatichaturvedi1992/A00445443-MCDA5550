import React from 'react'
import ReactDOM from 'react-dom'
import Title from './Title'
// import { render } from '@testing-library/react'

test('renders <Title>', () => {
    const div = document.createElement('div')
    ReactDOM.render(<Title />, div)
    expect(div.querySelector('h1').textContent).toBe('Hello World!')

    // Using @testing-library/react
    // const { getByRole } = render(<Title />)
    // const h1 = getByRole('heading')
    // expect(h1.textContent).toBe('Hello World!')
})



// Or you can use Jest DOM (toHaveTextContent) -> 
// expect(div.querySelector('h1')).toHaveTextContent('Hello World!')

// Check API Docs for Jest DOM here -> https://github.com/testing-library/jest-dom#table-of-contents 
// create-react-app already imports this module for us in setupTests.js 