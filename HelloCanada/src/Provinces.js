import React, { Component } from "react"
import Province from "./Province"

import { getProvincesData } from "./api";

class Provinces extends Component {

    constructor(props) {
        super(props)
        this.state = {
            provinces: []
        }
        this.fetchData = this.fetchData.bind(this);
    }

    fetchData() {
        getProvincesData()
            .then(response => {
                // console.log(response);
                this.setState({
                    provinces: response
                })
            });
    }

    componentDidMount() {
        this.fetchData()
    }


    render() {
        return (
            <div>
                {this.state.provinces.map(province => {
                    return <Province key={province.name} name={province.name} capital={province.capital} flagUrl={province.flagUrl} />
                })}
            </div>
        )
    }
}

/**
 * Topics you might also like:
 *      - Array.map() -> https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map
 */

export default Provinces;