import React, { Component } from "react"
import { getRandomUser } from "./api";

class User extends Component {
    constructor(props) {
        super(props)
        this.state = {
            firstName: '',
            lastName: '',
            age: null,
            email: '',
            city: '',
            country: '',
            pictureURL: '',

            isShowAddress: false
        }
        this.fetchData = this.fetchData.bind(this);
    }

    fetchData() {
        getRandomUser()
            .then(response => {
                // console.log(response.results[0]);
                const data = response.results[0]
                this.setState({
                    firstName: data.name.first,
                    lastName: data.name.last,
                    age: data.dob.age,
                    email: data.email,
                    city: data.location.city,
                    country: data.location.country,
                    pictureURL: data.picture.large
                })
            });
    }

    componentDidMount() {
        this.fetchData()
    }

    render() {
        return (
            <div className="user-container" key={this.state.email}>
                <img alt={`${this.state.firstName} ${this.state.lastName}`} width={175} src={this.state.pictureURL} />
                <div>
                    <h2 data-testid="user-name">{this.state.firstName} {this.state.lastName}</h2>
                    <p><b>Age: </b>{this.state.age}</p>
                    <p><b>Email: </b>{this.state.email}</p>
                    {this.state.isShowAddress ? <p><b>Address: </b>{this.state.city}, {this.state.country}</p> : undefined}
                </div>
                <div>
                    <button
                        data-testid="user-btn"
                        onClick={() => this.setState({ isShowAddress: !this.state.isShowAddress })}
                        className={this.state.isShowAddress ? "btn-hide" : "btn-show"}
                    >
                        {this.state.isShowAddress ? "Hide Address" : "Show Address"}
                    </button>
                </div>
            </div>
        )
    }
}

export default User;
