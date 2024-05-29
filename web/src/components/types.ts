export interface People {
    name: string;
    height: string;
    mass: string;
    hair_color: string;
    skin_color: string;
    eye_color: string;
    birth_year: string;
    gender: string;
    homeworld: string;
    films: Film[];
    species: Specie[];
    vehicles: Vehicle[];
    starships: Starship[];
    created: string;
    edited: string;
    url: string;
}

export interface Film {
    title: string;
    episode_id: string;
    opening_crawl: string;
    director: string;
    producer: string;
    release_date: string;
    characters: People[];
    planets: Planet[];
    starships: Starship[];
    vehicles: Vehicle[];
    species: Specie[];
    created: string;
    edited: string;
    url: string;
}

export interface Specie {
    title: string;
    episode_id: string;
    opening_crawl: string;
    director: string;
    producer: string;
    release_date: string;
    characters: People[];
    planets: Planet[];
    starships: Starship[];
    vehicles: Vehicle[];
    species: Specie[];
    created: string;
    edited: string;
    url: string;
}

export interface Starship {
    name: string;
    model: string;
    manufacturer: string;
    cost_in_credits: string;
    length: string;
    max_atmosphering_speed: string;
    crew: string;
    passengers: string;
    cargo_capacity: string;
    consumables: string;
    hyperdrive_rating: string;
    MGLT: string;
    starship_class: string;
    pilots: People[];
    films: Film[];
    created: string;
    edited: string;
    url: string;
}

export interface Vehicle {
    name: string;
    model: string;
    manufacturer: string;
    cost_in_credits: string;
    length: string;
    max_atmosphering_speed: string;
    crew: string;
    passengers: string;
    cargo_capacity: string;
    consumables: string;
    vehicle_class: string;
    pilots: People[];
    films: Film[];
    created: string;
    edited: string;
    url: string;
}

export interface Planet {
    name: string;
    rotation_period: string;
    orbital_period: string;
    diameter: string;
    climate: string;
    gravity: string;
    terrain: string;
    surface_water: string;
    population: string;
    residents: People[];
    films: Film[];
    created: string;
    edited: string;
    url: string;
}

export interface DetailAttribute {
    label: string;
    key: string;
}

export interface DetailList {
    label: string;
    key: string;
}

export interface EntityDetailsConfig {
    title: string;
    mainProperty: string;
    attributes: DetailAttribute[];
    lists: DetailList[];
}
  