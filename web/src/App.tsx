import React from 'react'
import './App.css'
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import CharacterList from './pages/CharacterList.tsx';
import CharacterDetails from "./pages/CharacterDetails.tsx";
import FilmDetails from "./pages/FilmDetails.tsx";
import StarshipDetails from "./pages/StarshipDetails.tsx";
import VehicleDetails from "./pages/VehicleDetails.tsx";
import PlanetDetails from "./pages/PlanetDetails.tsx";
import SpeciesDetails from "./pages/SpeciesDetails.tsx";

const App: React.FC = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<CharacterList/>}/>
                <Route path="/people/:id" element={<CharacterDetails/>}/>
                <Route path="/detail/people/:id" element={<CharacterDetails/>}/>
                <Route path="/films/:filmId" element={<FilmDetails/>}/>
                <Route path="/starships/:starshipId" element={<StarshipDetails/>}/>
                <Route path="/vehicles/:vehicleId" element={<VehicleDetails/>}/>
                <Route path="/planets/:planetId" element={<PlanetDetails/>}/>
                <Route path="/species/:speciesId" element={<SpeciesDetails/>}/>
            </Routes>

        </Router>
    );
};

export default App
