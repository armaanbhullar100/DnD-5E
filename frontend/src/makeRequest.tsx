const makeRequest = async (route: string, method: string, token: string, body: any) => {
    const options = await fetch(route, {
        method: method,
        headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + token
        },
        body: JSON.stringify(body)
    });
    return fetch('http://localhost:3000' + route, options);
}

export default makeRequest;