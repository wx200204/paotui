<template>
    <div>
      <Header title="建议详情"></Header>
      <p class="suggestion-content">{{ suggestion.suggestion }}</p>
      <van-button class="read-button" color="#1751f1" @click="markAsRead">已读</van-button>
      <van-button class="back-button" color="#1751f1" @click="goBack">返回</van-button>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import Header from '@/components/Header.vue';
  export default {
    components: { 
      Header
    },
    data() {
      return {
        suggestion: '',
      };
    },
    methods: {
      fetchSuggestion() {
        const suggestionId = this.$route.params.id;
        axios.get(`http://localhost:9090/sug/suggestion/${suggestionId}`)
          .then(response => {
            this.suggestion = response.data;
          })
          .catch(error => {
            console.error('Error fetching suggestion detail:', error);
          });
      },
      markAsRead() {
        axios.put(`http://localhost:9090/sug/markAsRead/${this.$route.params.id}`)
          .then(response => {
            console.log('Marked as read:', response.data);            
          })
          .catch(error => {
            console.error('Error marking as read:', error);
          });
      },
      goBack() {
        // 返回上一级列表
        this.$router.go(-1);
      },
    },
    mounted() {
      this.fetchSuggestion();
    },
  };
  </script>
  
  <style scoped>
  .suggestion-content {
    max-width: 400px;
    overflow-wrap: break-word;
    font-size: 7px; /* 调整字体大小 */
  }
  
  .read-button {
    margin-right: 20px;
    margin-left: 35px;
  }
  
  .back-button {
  }
  </style>
  