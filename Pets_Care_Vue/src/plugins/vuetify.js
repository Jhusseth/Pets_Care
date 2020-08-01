import Vue from 'vue';
import Vuetify from 'vuetify/lib';

import colors from 'vuetify/lib/util/colors'
import 'vuetify/dist/vuetify.min.css'
import '@fortawesome/fontawesome-free/css/all.css'

Vue.use(Vuetify);

export default new Vuetify({
    theme: { 
      themes: {
        light: {
          primary: '#00bcd4',
          secondary: '#e91e63',
          accent: '#3f51b5',
          error: '#f44336',
          warning: '#ffc107',
          info: '#607d8b',
          success: '#009688'  
        },
        dark:{
          primary: colors.orange.accent4,
          secondary: colors.grey.lighten4,
          accent: colors.grey.accent4,
          error:colors.red.accent4,
          info:colors.green.lighten5,
          succes:colors.green.accent3,
          warning:colors.yellow.accent2,
        }
        ,
      },
    },
    icons:{
      // iconfont:'fa',
      val:[{
        facebook:'mdi-facebook'
        }
      ]
    },
    customProperties:false,
    // iconfont:'md'
});
