<template>
    <div class="signin">
        <h2>Signin</h2>
        <div class="input-form-wrapper">
            <el-input type="text" placeholder="Username" v-model="username"></el-input>
        </div>
        <div class="input-form-wrapper">
            <el-input type="password" placeholder="Password" v-model="password"></el-input>
        </div>
        <el-button @click="signIn">Signin</el-button>
        <p>You don't have as account?
            <router-link to="/signup">Create Account</router-link>
        </p>
    </div>
</template>

<script>
import firebase from 'firebase'
export default {
    name: 'Signin',
    data(){
        return{
            username: '',
            password: ''
        }
    },
    methods: {
        signIn: async function(){
            await firebase.auth().signInWithEmailAndPassword(this.username, this.password)
            .then(() => this.$router.push('/'))
            .catch((error) => {
                this.$message({
                    showClose: true,
                    message: error,
                    type: 'error'
                })
            })
        }
    }
}
</script>
