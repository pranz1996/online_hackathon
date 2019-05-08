import React, { Component } from 'react'
import axios from 'axios'
import { Redirect } from 'react-router'
import Header from '../Miscellanous/Header';
import Footer from '../Miscellanous/Footer';

export default class SearchOrganization extends Component {
    constructor(props) {
        super(props)
        this.state = {

        }

    }

    submitHandler = (h) => {
        h.preventDefault()
        const data = {

        }
        // axios.defaults.withCredentials = true
        axios.post('http://localhost:8080/hackathons', data)
            .then(response => {

                console.log(response.data.id)
                if (response.status === 200) {
                    this.setState({
                        successFlag: true
                    })
                }
            })
    }

    render() {

        return (
            <div>
                <div class="form-group">
                    <div class="card" >
                        <div class="card-body">
                            <h6 class="card-title">Team Name</h6>
                            <p class="card-text">URL: <a href="www.submission.com">www.submission.com</a></p>
                            
                            <input type="text" class="hackathonscore-form-control" id="colFormLabelSm" placeholder="" />
                            <span class="judge-tab" />
                            <button type="button" class="btn btn-outline-warning btn-sm">Submit Score</button>
                            <span class="judge-tab" /><span class="judge-tab" />Submitted at: 00/00/0000 00:00:00
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
