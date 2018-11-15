<template>
    <el-row>
        <sub-header/>
        <el-col :span="24">
            <el-card class="box-card box-card-wrapper">
                <div slot="header">
                    <span>カテゴリー追加</span>
                </div>
                <el-row class="row-wrapper">
                    <el-col :span="12">
                        <span>カテゴリー名
                        </span>
                    </el-col>
                    <el-col :span="12">
                        <el-input
                        v-model="request.name"
                        placeholder="New Name..."
                        clearable></el-input>
                    </el-col>
                </el-row>
                <el-row class="row-wrapper">
                    <el-col :span="24">
                        <el-button
                        type="success"
                        @click="addCategory">追加</el-button>
                    </el-col>
                </el-row>
            </el-card>
        </el-col>
        <el-col :span="24">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <span>カテゴリー一覧</span>
                </div>
                <el-table
                :data="category"
                style="width:100%">
                    <el-table-column
                    prop="id"
                    label="カテゴリーID"
                    width="200"
                    align="left"></el-table-column>
                    <el-table-column
                    prop="name"
                    label="カテゴリー名"
                    width="200"
                    align="left"></el-table-column>
                    <el-table-column
                    prop="created_at"
                    label="登録日時"
                    width="200"
                    align="left"></el-table-column>
                    <el-table-column
                    prop="updated_at"
                    label="更新日時"
                    width="200"
                    align="left"></el-table-column>
                    <el-table-column
                    prop="operation"
                    label="Ops"
                    width="200"
                    align="left">
                        <template slot-scope="scope">
                            <el-button
                            size="mini"
                            type="danger"
                            @click="deleteCategory(scope.row.id)">×</el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
import axios from 'axios'
import SubHeader from '../components/SubHeader'
export default {
    name: 'category',
    components: {SubHeader},
    data() {
        return {
            request: {
                name: undefined
            },
            category: []
        }
    },
    created: async function(){
        await this.refresh()
    },
    methods: {
        refresh: async function(){
            axios.get('http://localhost:8080/api/category/')
            .then((response) => {
                this.category = response.data.categories
            })
            .catch((error) => {
                throw new Error(error)
            })
            this.request.name = undefined
        },
        addCategory: async function(){
            await axios.post('http://localhost:8080/api/category/')
            await this.refresh()
            this.$message({
                showClose: true,
                message: 'Add Category Success',
                type: 'success'
            })
        },
        deleteCategory: async function(id){
            await axios.put('http://localhost:8080/api/category/' + id)
            await this.refresh()
            this.$message({
                showClose: true,
                message: 'Delete Category Success',
                type: 'success'
            })
        }
    }
}
</script>
