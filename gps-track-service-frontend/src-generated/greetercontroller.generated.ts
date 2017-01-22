import { Greeting } from './greeting.model.generated';

import axios from 'axios'

export class GreeterController {
    private serviceBaseURL = '/api/greetings';

    constructor() {
        console.log('Creating GreeterController')
    }

    /* GET */
    
    public greetNoNameGet(): Promise<Greeting> {
        let url = this.serviceBaseURL + '';

        return new Promise<Greeting> (function (resolve, reject) {
            axios.get(url).then(function (response) {
                resolve(<Greeting>JSON.parse(response.data));
            })
            .catch(function (error) {
                reject(error);
            });
        });
    }

    
    public greetNameGet(name: string): Promise<Greeting> {
        let url = this.serviceBaseURL + '/' + name + '';

        return new Promise<Greeting> (function (resolve, reject) {
            axios.get(url).then(function (response) {
                resolve(<Greeting>JSON.parse(response.data));
            })
            .catch(function (error) {
                reject(error);
            });
        });
    }


    /* HEAD */

    /* POST */

    /* PUT */

    /* PATCH */

    /* DELETE */

    /* OPTIONS */

    /* TRACE */

}

