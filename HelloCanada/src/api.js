import provinces from './data/provinces-data'
import territories from './data/territories-data'

const getProvincesData = () => {
    return new Promise((resolve, reject) => {
        resolve(provinces)
    })
}

const getTerritories = () => {
    return new Promise((resolve, reject) => {
        resolve(territories)
    })
}

const getCovid19Info = () => {
    return new Promise((resolve, reject) => {
        fetch("https://api.covid19tracker.ca/summary")
            .then(response => {
                resolve(response.json())
            })
    })
}

export { getProvincesData, getTerritories, getCovid19Info };