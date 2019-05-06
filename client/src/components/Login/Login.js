import React, { Component } from 'react'
import axios from 'axios'
import { Redirect } from 'react-router'
import Header from '../Miscellanous/Header';
import Footer from '../Miscellanous/Footer';

export default class Login extends Component {
    constructor(props) {
        super(props)
        this.state = {
            email: "",
            password: ""
        }

        this.emailHandler = this.emailHandler.bind(this);
        this.passwordHandler = this.passwordHandler.bind(this);

    }

    componentWillMount() {
        this.setState({
    
        })
    }

    emailHandler = (h) => {
        this.setState({
            email: h.target.value
        })
    }

    passwordHandler = (h) => {
        this.setState({
            password: h.target.value
        })
    }

  
    submitHandler = (h) => {
        h.preventDefault()
        const data = {
            email: this.state.email,
            password: this.state.password
           
        }
        this.props.history.push('/user');
        console.log(data);
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
        const openhacklogo = require('../Miscellanous/openhack.png');
        return (
            <div style={{ backgroundColor: "#243e8c" }}>
           <div style={{ backgroundColor: "#243e8c" }}>
                <Header />
                <div style={{ backgroundColor: "#243e8c" }}>
                    <div class="login-form">
                        <div class="main-div">
                            <div class="panel">
                                <img src={openhacklogo} width="75px" height="75px" />
                                <h2>OpenHack</h2><br /><br/>
                            </div>
                            <form onSubmit={this.submitHandler}>
                            <div class="form-group">
                                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email" onChange={this.emailHandler} required/>
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Password" onChange={this.passwordHandler} required/>
                                </div>
                                <br />
                                <button type="submit" class="btn btn-secondary btn-lg btn-block">Login</button><br />
                                <div class="alert alert-info" role="alert">
                                    Have an account? <a href="localhost:8080/signup">Sign in here</a>
                                </div>
                    
                            </form>
                        </div>
                        </div>
                    </div>
                    <Footer />
                </div >
                </div>
                )
            }
        }
