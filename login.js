import axios from 'axios';

const pubRoot = new axios.create({
  baseURL: "http://localhost:3000"
});

async function createUser({first, last}) {
  return await pubRoot.post(`/users/`, {
    data: {
            id : {first, last}
        }
  })
}

async function getUser(id) {
  return await pubRoot.get('/users/' + id);
}


export const handleSignupFormSubmit = function(event) {
    // Load data from form

    createUser({firstName : "",
                lastName : ""});
}

export const loadFormIntoDOM = function() {

    const $root = $('#root');

    $root.on('click',".submit", handleSignupFormSubmit);
}

$(function() {
    loadFormIntoDOM();
});