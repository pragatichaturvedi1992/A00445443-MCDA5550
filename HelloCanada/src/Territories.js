import React, { Component } from "react"
import Province from "./Province"

import { getTerritories } from "./api";

class Territories extends Component {

    constructor(props) {
        super(props)
        this.state = {
            territories: []
        }
        this.fetchData = this.fetchData.bind(this);
    }

    fetchData() {
        getTerritories()
            .then(response => {
                // console.log(response);
                this.setState({
                    territories: response
                })
            });
    }

    componentDidMount() {
        this.fetchData()
    }


    render() {
        return (
            <div>
                {this.state.territories.map(territory => {
                    return <Province key={territory.name} name={territory.name} capital={territory.capital} flagUrl={territory.flagUrl} />
                })}
            </div>
        )
    }
}

export default Territories;