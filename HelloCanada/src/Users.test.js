import React from 'react'
import { render } from '@testing-library/react'
import Users from './Users'

test('renders <Users>', () => {
    const { getAllByTestId } = render(<Users />)
    const userNames = getAllByTestId('user-name')
    expect(userNames.length).toBe(4)
})


// Check API Docs for React Testing Library here -> https://testing-library.com/docs/react-testing-library/intro/
// Tutorial here -> https://www.robinwieruch.de/react-testing-library