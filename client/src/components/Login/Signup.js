import React, { Component } from 'react'
import axios from 'axios'
import { Redirect } from 'react-router'
import { Route } from 'react-router-dom';
import Header from '../Miscellanous/Header';
import Footer from '../Miscellanous/Footer';
import fire from '../../fire';
import sendemail from './helperFunctions'
import createUser from './helper2';

export default class Signup extends Component {
    constructor(props) {
        super(props)
        this.state = {
            username: "",
            password: "",
            repeatpassword: "",
            email: "",
            successFlag : "",
            isAdmin: ""
        }

        this.isAdmin = this.isAdminHandler.bind(this);
        this.usernameHandler = this.usernameHandler.bind(this);
        this.passwordHandler = this.passwordHandler.bind(this);
        this.repeatpasswordHandler = this.repeatpasswordHandler.bind(this);
        this.emailHandler = this.emailHandler.bind(this);
    }

    componentWillMount() {
        this.setState({
            successFlag : false
        })
    }

    isAdminHandler = (h) => {
        this.setState({isAdmin: h.target.value})
    }
    
    usernameHandler = (h) => {
        this.setState({username: h.target.value})
    }

    passwordHandler = (h) => {
        this.setState({password: h.target.value})
    }

    repeatpasswordHandler = (h) => {
        this.setState({repeatpassword: h.target.value})
    }

    emailHandler = (h) => {
        this.setState({email: h.target.value})
    }

    submitHandler = (h) => {
        h.preventDefault()
        // var adminstr = "@sjsu.edu";
        // var isAdmin=0;
        // if(this.state.email.includes(adminstr)){
        //     console.log("admin email");
        //     isAdmin = 1;
        // }

        const data = {
            userName: this.state.username,
            email: this.state.email,
            password: this.state.password,
        //    isAdmin: isAdmin
        }
        
        console.log("signup: ", data);
        // axios.defaults.withCredentials = true
        axios.post('http://localhost:8080/users', data)
            .then(response => {
                console.log(" response : " ,response)
                console.log(" response status : " , response.status)
                if (response.status === 200) {
                    this.setState({
                        successFlag: true
                    })
                }
            })

            //firebase

        //    export default function createAccount(h){
        //         h.preventDefault();
        //         var email = this.state.email;
        //         var password = this.state.password;
        //         console.log("in firebase", email);
        //         console.log("in firebase", password);

        //         fire.auth().createUserWithEmailAndPassword(email, password).catch(function (error) {
        //             // Handle Errors here.
        //             var errorCode = error.code;
        //             var errorMessage = error.message;
        //             // ...
        //             console.log("error" + errorMessage);
        //         });
        //     }

        // var email = this.state.email;
        // var password = this.state.password;
        // console.log("in firebase", email);
        // console.log("in firebase", password);
        // console.log("here");
        // var user = fire.auth().currentUser;
        // // // var isverified = user.emailVerified;
        // // // if(user!=null){
        // // //     var email = user.email;
        // // //     console.log("email", email);
        // // // }
        // console.log("user", user);
        // // // console.log(isverified);
        // createUser(email,password);
        // this.props.history.push('/showEmailSent')

        // sendemail(user);

            //  function sendVerification(h){
            //     h.preventDefault();
            //     var user = fire.auth().currentUser;
            //     var isverified = user.emailVerified;
            //     console.log(isverified);

            //     user.sendEmailVerification().then(function () {
            //         window.alert("Verification Sent");
            //     }).catch(function (error) {
            //         var errorMessage = error.message;
            //         console.log("error" + errorMessage);
            //     });
            // }
    }

    render() {
        let redirectVar = null
        if(this.state.successFlag) 
            redirectVar = <Redirect to="/login" />
        const openhacklogo = require('../Miscellanous/openhack.png');
        return (
            <div style={{ backgroundColor: "#eceff1" }}>
            {redirectVar}
                {/* <Header /> */}
                <div>
                    <div class="login-form">
                        <div class="main-div">
                            <div class="panel">
                                <img src={openhacklogo} width="75px" height="75px" />
                                <h2>OpenHack</h2><br />
                            </div>
                            <form onSubmit={this.submitHandler}>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="username" placeholder="Username" onChange={this.usernameHandler} required/>
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Password" onChange={this.passwordHandler} required />
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Re-enter Password" onChange={this.repeatpasswordHandler} required/>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email" onChange={this.emailHandler} required/>
                                </div>
                                <br />
                            
                                
                                    <br/>
                                <button type="submit" class="btn btn-secondary btn-lg btn-block">Sign Up</button><br />
                                <div class="alert alert-info" role="alert">
                                    Have an account? <a href="/login">Sign in here</a>
                                </div>
                             
                            </form>
                        </div>
                    </div>
                </div>
                <Footer />
            </div >
        )
    }
}