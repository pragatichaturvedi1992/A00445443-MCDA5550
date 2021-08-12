import React from 'react'
import { render, waitFor, fireEvent } from '@testing-library/react'
import Provinces from './Provinces'
import { getProvincesData } from './api'

const mockProvince = [
    {
        name: 'Ontario',
        capital: 'Toronto',
        flagUrl: 'https://upload.wikimedia.org/wikipedia/commons/8/88/Flag_of_Ontario.svg'
    }
]

jest.mock('./api')

test('renders <User>', async () => {
    getProvincesData.mockResolvedValueOnce(mockProvince)
    const { getByText, getByTestId, queryByText } = render(<Provinces />)
    await waitFor(() => expect(getProvincesData).toHaveBeenCalledTimes(1))
    expect(getByText('Ontario')).toBeTruthy()

    const button = getByTestId("user-btn")
    expect(button.innerHTML).toBe("Show Capital")
    fireEvent.click(button)
    expect(button.innerHTML).toBe("Hide Capital")
    expect(getByText('Toronto')).toBeTruthy()
    fireEvent.click(button)
    expect(queryByText('Toronto')).toBeFalsy()

    // cleanup
    getProvincesData.mockReset()
})


