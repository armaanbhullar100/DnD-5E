const makeRequest = async (route: string, method: string, token: string, body: any) => {
    const options = {
        method: method,
        headers: {
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + token
        },
        body: JSON.stringify(body)
    }
    const response = await fetch('http://localhost:8000' + route, options);
    return response;
}

export default makeRequest;