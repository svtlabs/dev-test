import {Attribute} from './Attribute';
import ListLinks from './ListLinks';
import type {EntityDetailsConfig} from './types';

interface Entity {
    name?: string;
    title?: string;
    created?: string;
    edited?: string;
    url?: string;

    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    [key: string]: any;
}

const DetailPage = ({entity, entityDetails, imagePath}: {
    entity: Entity,
    entityDetails: EntityDetailsConfig,
    imagePath: string
}) => {
    return (
        <div>
            <h1>{entityDetails.title} details</h1>
            <div className="details">
                <div className="text-content">
                    <h2>{entity[entityDetails.mainProperty]}</h2>
                    {entityDetails.attributes.map(attr => (
                        <Attribute key={attr.label} label={attr.label} value={entity[attr.key]}/>
                    ))}
                    {entityDetails.lists.map(list => (
                        <ListLinks key={list.label} label={`${list.label}:`} list={entity[list.key]}/>
                    ))}
                </div>
                <img src={imagePath} alt={entity[entityDetails.mainProperty]}/>
            </div>
        </div>
    );
};

export default DetailPage;
