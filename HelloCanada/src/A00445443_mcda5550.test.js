import React from 'react'
import ReactDOM from 'react-dom'
import { render, waitFor, fireEvent } from '@testing-library/react'
import Provinces from './Provinces'
import Territories from './Territories'
import App from './App'

test('Check the fetched province Length', async () => {
    const { queryAllByTestId } = await render(<Provinces />)
    const provinces = queryAllByTestId('province-test')
    expect(provinces.length).toBe(10)
})

test('Check the fetched Territories Length', async () => {
    const { queryAllByTestId } = await render(<Territories />)
    const territories = queryAllByTestId('province-test')
    expect(territories.length).toBe(3)
})

test('Checks for title', () => {
    const div = document.createElement('div')
    ReactDOM.render(<App />, div)
    expect(div.querySelector('h1').textContent).toBe('Hello Canada')
})
    