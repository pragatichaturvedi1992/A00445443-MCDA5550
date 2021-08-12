import React from 'react'
import { render, waitFor, fireEvent } from '@testing-library/react'
import User from './User'
import { getRandomUser } from './api'

const mockUser = {
    results: [
        {
            name: {
                first: "Simon",
                last: "Achkar"
            },
            location: {
                city: "Halifax",
                country: "Canada",
            },
            email: "simon.achkar@example.com",
            dob: {
                age: 25
            },
            picture: {
                large: "https://avatars.githubusercontent.com/u/19724710?s=400&u=922bd93f5aac87244196f750e2ca386d7f3c0251&v=4",
            },
        }
    ],
}

jest.mock('./api')

test('renders <User>', async () => {
    getRandomUser.mockResolvedValueOnce(mockUser)
    const { getByText, getByTestId, queryByText, debug } = render(<User />)
    await waitFor(() => expect(getRandomUser).toHaveBeenCalledTimes(1))
    expect(getByText('Simon Achkar')).toBeTruthy()

    const button = getByTestId("user-btn")
    expect(button.innerHTML).toBe("Show Address")
    fireEvent.click(button)
    expect(button.innerHTML).toBe("Hide Address")
    expect(getByText('Halifax, Canada')).toBeTruthy()
    fireEvent.click(button)
    // expect(getByText('Halifax, Canada')).toBeFalsy()
    expect(queryByText('Halifax, Canada')).toBeFalsy()

    // cleanup
    getRandomUser.mockReset()
})


// Check API Docs for React Testing Library here -> https://testing-library.com/docs/react-testing-library/intro/
// Tutorial here -> https://www.robinwieruch.de/react-testing-library

// Use debug() to get a view of the component