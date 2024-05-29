import React, {useEffect, useState} from "react";
import {useParams} from 'react-router-dom';
import DetailPage from '../components/DetailPage';
import {getImagePath} from "../components/util";
import {Vehicle} from "../components/types";
import {endpoints} from "../components/endpoints.ts";

const vehicleDetailsConfig = {
    title: "Vehicle",
    mainProperty: 'name',
    attributes: [
        {label: "Name", key: "name"},
        {label: "Model", key: "model"},
        {label: "Manufacturer", key: "manufacturer"},
        {label: "Cost in credits", key: "cost_in_credits"},
        {label: "Max atmosphering speed", key: "max_atmosphering_speed"},
        {label: "Crew", key: "crew"},
        {label: "Passengers", key: "passengers"},
        {label: "Cargo capacity", key: "cargo_capacity"},
        {label: "Consumables", key: "consumables"},
        {label: "Vehicle class", key: "vehicle_class"},
        {label: "Created", key: "created"},
        {label: "Edited", key: "edited"},
        {label: "Url", key: "url"}
    ],
    lists: [
        {label: "Pilots", key: "pilots"},
        {label: "Films", key: "films"}
    ]
};

const VehicleDetails: React.FC = () => {
    const {vehicleId} = useParams<{ vehicleId: string }>();
    const [vehicle, setVehicle] = useState<Vehicle>();
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchVehicle = async () => {
            try {
                const response = await fetch(endpoints.vehicles(vehicleId as string));
                const data = await response.json();
                setVehicle(data);
            } catch (error) {
                console.error('Failed to fetch vehicle', error);
            } finally {
                setLoading(false);
            }
        };

        fetchVehicle();
    }, [vehicleId]);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (!vehicle) {
        return <div>Vehicle not found.</div>;
    }

    const imagePath = getImagePath(vehicle.url);

    return (
        <DetailPage entity={vehicle} entityDetails={vehicleDetailsConfig} imagePath={imagePath}/>
    );
};

export default VehicleDetails;
