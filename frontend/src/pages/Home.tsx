import { useState } from 'react';

function Home() {
    const [name, setName] = useState('');
    const [job, setJob] = useState('');
    const [background, setBackground] = useState('');
    const [race, setRace] = useState('');

    const handleSubmit = async () => {
        const response = await fetch('http://localhost:8000/test', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        });
        // console.log(response);
        const data = await response.json();
        console.log(data);
    }

    return (
        <div>
            <label htmlFor="name-select">Name: </label>
            <input type="text" placeholder="Choose a name" id='name=select' onChange={(e) => setName(e.target.value)} />{name}<br />
            <label htmlFor="race-select">Choose a race: </label>
            <select name="races" id="race-select" onChange={(e) => setRace(e.target.value)}>
                <option value="" selected disabled hidden>--Race--</option>
                <option value="human">Human</option>
                <option value="elf">Elf</option>
                <option value="dwarf">Dwarf</option>
                <option value="halfling">Halfling</option>
                <option value="gnome">Gnome</option>
                <option value="half elf">Half-Elf</option>
                <option value="half orc">Half-Orc</option>
                <option value="tiefling">Tiefling</option>
                <option value="dragonborn">Dragonborn</option>
            </select>{race}<br />
            <label htmlFor='background-select'>Choose a background: </label>
            <select name='backgrounds' id='background-select' onChange={(e) => setBackground(e.target.value)}>
                <option value="" selected disabled hidden>--Background--</option>
                <option value="background1">Background1</option>
                <option value="background2">Background2</option>
            </select>{background}<br />
            <label htmlFor='class-select'>Choose a class: </label>
            <select name='classs' id='class-select' onChange={(e) => setJob(e.target.value)}>
                <option value="" selected disabled hidden>--Class--</option>
                <option value="class1">class1</option>
                <option value="class2">class2</option>
            </select>{job}<br />
            <button onClick={handleSubmit}>Submit</button>
        </div>
    );
}

export default Home;