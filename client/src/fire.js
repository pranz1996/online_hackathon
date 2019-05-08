import firebase from 'firebase';
import { expression } from '@babel/template';

var firebaseConfig = {
    apiKey: "AIzaSyDza4B569Sr16p1KPZ83BmPcPhwdP6kJVs",
    authDomain: "openhack-27508.firebaseapp.com",
    databaseURL: "https://openhack-27508.firebaseio.com",
    projectId: "openhack-27508",
    storageBucket: "openhack-27508.appspot.com",
    messagingSenderId: "724274765403",
    appId: "1:724274765403:web:1bcbf8057ca381b0"
  };
  // Initialize Firebase
const fire = firebase.initializeApp(firebaseConfig);
export default fire;