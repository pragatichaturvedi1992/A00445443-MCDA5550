import React, { Component } from "react"
import { getCovid19Info } from "./api";

class Covid19 extends Component {
    constructor(props) {
        super(props)
        this.state = {
            lastestDate: '',
            totalCases: '',
            totalDeaths: '',
            totalVaccinated: '',
            changeCases: '',
            changeDeaths: ''
        }
        this.fetchData = this.fetchData.bind(this);
    }

    fetchData() {
        getCovid19Info()
            .then(response => {
                // console.log(response);
                this.setState({
                    lastestDate: response.data[0].latest_date,
                    totalCases: response.data[0].total_cases,
                    totalDeaths: response.data[0].total_fatalities,
                    totalVaccinated: response.data[0].total_vaccinated,
                    changeCases: response.data[0].change_cases,
                    changeDeaths: response.data[0].change_fatalities
                })
            });
    }

    componentDidMount() {
        this.fetchData()
    }

    render() {
        return (
            <div className="covid19-container">
                <p><b>Lastest Date: </b>{this.state.lastestDate}</p>
                <p><b>Total Cases: </b>{this.state.totalCases}</p>
                <p><b>Total Deaths: </b>{this.state.totalDeaths}</p>
                <p><b>Total Vaccinated: </b>{this.state.totalVaccinated}</p>
                <p><b>Change Cases: </b>{this.state.changeCases}</p>
                <p><b>Change Deaths: </b>{this.state.changeDeaths}</p>
            </div>
        )
    }
}

export default Covid19;