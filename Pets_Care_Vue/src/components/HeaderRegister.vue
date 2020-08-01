<template>
    <div>
        <v-app-bar color="primary" dark>
            <v-app-bar-nav-icon >
            </v-app-bar-nav-icon>

            <v-toolbar-title >PETSCARE</v-toolbar-title>
            <v-spacer></v-spacer>
            <div v-if="$vuetify.theme.dark">
                <v-btn small rounded color="primary" v-on:click="changeTheme">
                    <v-icon>fas fa-sun</v-icon>
                </v-btn>
            </div>
            <v-div v-else>
                <v-btn small rounded color="primary" v-on:click="changeTheme">
                    <v-icon>fas fa-moon</v-icon>
                </v-btn>
            </v-div>
            <router-link to='/login'>
                <v-btn small rounded color="primary">
                    <v-icon>mdi-account-supervisor</v-icon> 
                    
                </v-btn>
            </router-link>
            <router-link to='/'>
                <v-btn small rounded color="primary">
                    <v-icon>mdi-home</v-icon>
                </v-btn>
            </router-link>
        </v-app-bar>
    </div> 
</template>

<script>
export default {
    name: 'HeaderRegister',
    methods:{
        changeTheme(){
            this.$vuetify.theme.dark = !this.$vuetify.theme.dark
        }
    }

}
</script>

<style scoped>

</style>