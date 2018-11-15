<template>
    <div class="signup">
        <h2>Signup</h2>
        <div class="input-form-wrapper">
            <el-input type="text" placeholder="Username" v-model="username"></el-input>
        </div>
        <div class="input-form-wrapper">
            <el-input type="password" placeholder="Password" v-model="password"></el-input>
        </div>
        <el-button @click="signUp">Register</el-button>
        <p>Do you hace an account?
            <router-link to='/signin'>sign in</router-link>
        </p>
    </div>
</template>

<script>
import firebase from 'firebase'
export default {
    name: 'Signup',
    data(){
        return{
            username: '',
            password: ''
        }
    },
    methods: {
        signUp: async function () {
            await firebase.auth().createUserWithEmailAndPassword(this.username, this.password)
            .then(() => {
                this.username = ''
                this.password = ''
                this.$message({
                    showClose: true,
                    message: 'Register user succcess',
                    type: 'success'
                })
                this.$router.push('/')
            })
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
