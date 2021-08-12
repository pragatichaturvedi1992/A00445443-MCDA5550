const getRandomUser = () => {
    return new Promise((resolve, reject) => {
        fetch("https://randomuser.me/api")
            .then(response => {
                resolve(response.json())
            })
    })
}

export { getRandomUser };